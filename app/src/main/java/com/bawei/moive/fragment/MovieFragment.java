package com.bawei.moive.fragment;

import android.Manifest;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.LatLng;
import com.bawei.moive.R;
import com.bawei.moive.activity.MoreActivity;
import com.bawei.moive.activity.SearchActivity;
import com.bawei.moive.adapter.MovieHotAdapter;
import com.bawei.moive.adapter.MovieLoadingAdapter;
import com.bawei.moive.adapter.MovieUpcomingAdapter;
import com.bawei.moive.base.BaseFragment;
import com.bawei.moive.base.BasePresenter;
import com.bawei.moive.bean.LoadingMovieBean;
import com.bawei.moive.bean.UpcomingBean;
import com.bawei.moive.bean.XBannerBean;
import com.bawei.moive.contract.MovieContract;
import com.bawei.moive.presenter.MoviePresenter;
import com.bawei.moive.utils.SPUtils;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @ProjectName: Moive
 * @Package: com.bawei.moive.fragment
 * @ClassName: MovieFragment
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/4/22 22:21
 */
public class MovieFragment extends BaseFragment implements MovieContract.IView, LocationSource, AMapLocationListener, EasyPermissions.PermissionCallbacks {
    @BindView(R.id.dingwei)
    ImageView dingwei;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.map)
    MapView mapView;
    @BindView(R.id.xbn)
    XBanner xbn;
    @BindView(R.id.more1)
    TextView more1;
    @BindView(R.id.fragment_loading_rv)
    RecyclerView fragmentLoadingRv;
    @BindView(R.id.more2)
    TextView more2;
    @BindView(R.id.fragment_upcoming_rv)
    RecyclerView fragmentUpcomingRv;
    @BindView(R.id.more3)
    TextView more3;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.bt_buy)
    Button btBuy;
    @BindView(R.id.fragment_hot_rv)
    RecyclerView fragmentHotRv;
    @BindView(R.id.search)
    ImageView search;
    //AMap是地图对象
    private AMap aMap;

    private MovieLoadingAdapter movieLoadingAdapter;
    private MovieHotAdapter movieHotAdapter;
    private MovieUpcomingAdapter movieUpcomingAdapter;

    @Override
    protected BasePresenter initPresenter() {
        return new MoviePresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void unEvent() {

    }
    boolean isYou=false;
    @Override
    protected void initView(View view) {
        String[] mPermissionList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(getContext(), mPermissionList)) {
            isYou=true;
            Toast.makeText(getContext(), "已有权限", Toast.LENGTH_SHORT).show();
            if (aMap == null) {
                aMap = mapView.getMap();
                //设置显示定位按钮 并且可以点击
                UiSettings settings = aMap.getUiSettings();
                aMap.setLocationSource(this);//设置了定位的监听
                // 是否显示定位按钮
                settings.setMyLocationButtonEnabled(true);
                aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
            }
            location();
        } else {
            //未同意过,或者说是拒绝了，再次申请权限
            EasyPermissions.requestPermissions(getActivity(), "需要定位的权限", 1, mPermissionList);
        }




        LinearLayoutManager LoadinghorizontalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        fragmentLoadingRv.setLayoutManager(LoadinghorizontalLinearLayoutManager);
        LinearLayoutManager HothorizontalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        fragmentHotRv.setLayoutManager(HothorizontalLinearLayoutManager);
        LinearLayoutManager verticalLinearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        fragmentUpcomingRv.setLayoutManager(verticalLinearLayoutManager);
        movieLoadingAdapter = new MovieLoadingAdapter(getContext());
        movieHotAdapter = new MovieHotAdapter(getContext());
        movieUpcomingAdapter = new MovieUpcomingAdapter(getContext());
        fragmentLoadingRv.setAdapter(movieLoadingAdapter);
        fragmentHotRv.setAdapter(movieHotAdapter);
        fragmentUpcomingRv.setAdapter(movieUpcomingAdapter);
    }


    @Override
    protected void initData() {


        BasePresenter presenter = getPresenter();
        if (presenter instanceof MoviePresenter) {
            ((MoviePresenter) presenter).showLoadingMovie(1, 3);
            ((MoviePresenter) presenter).showUpcomingMovie(1, 3);
            ((MoviePresenter) presenter).showHotMovie(1, 3);
            ((MoviePresenter) presenter).showBanner();
        }


    }


    @Override
    public void onLoadingSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            movieLoadingAdapter.setData(loadingMovieBean.getResult());
        }
    }

    @Override
    public void onLoadingFailure(String str) {

    }

    @Override
    public void onUpcomingSuccess(UpcomingBean upcomingBean) {
        if (upcomingBean != null) {
            movieUpcomingAdapter.setData(upcomingBean.getResult());
        }
    }

    @Override
    public void onUpcomingFailure(String str) {

    }

    @Override
    public void onHotSuccess(LoadingMovieBean loadingMovieBean) {
        if (loadingMovieBean != null) {
            movieHotAdapter.setData(loadingMovieBean.getResult());

            Glide.with(this).load(loadingMovieBean.getResult().get(0).getImageUrl()).into(iv);
            tv1.setText(loadingMovieBean.getResult().get(0).getName());
            tv2.setText(String.valueOf(loadingMovieBean.getResult().get(0).getScore()) + "分");
        }
    }

    @Override
    public void onHotFailure(String str) {

    }

    @Override
    public void onSuccess(XBannerBean xBannerBean) {
        if (xBannerBean != null) {
//            xBannerBeanList.add(xBannerBean);
//            xbn.setBannerData((xBannerBeanList);
            List<XBannerBean.ResultBean> result = xBannerBean.getResult();
            xbn.setBannerData(result);

            xbn.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(MovieFragment.this).load(result.get(position).getImageUrl()).into((ImageView) view);
                }
            });
        }
    }

    @Override
    public void onFailure(String str) {

    }

    @OnClick({R.id.more1, R.id.more2, R.id.more3,R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more1:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.more2:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.more3:
                startActivity(new Intent(getContext(), MoreActivity.class));
                break;
            case R.id.search:
                startActivity(new Intent(getContext(), SearchActivity.class));
                break;
            default:
                break;
        }
    }





    //地图
    private boolean isFirstLoc = true;
    private String city1;
    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;
    //声明mListener对象，定位监听器
    private OnLocationChangedListener mListener = null;
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见官方定位类型表
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码

                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLoc) {
                    //设置缩放级别
                    aMap.moveCamera(CameraUpdateFactory.zoomTo(17));
                    //将地图移动到定位点
                    aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                    //点击定位按钮 能够将地图的中心移动到定位点
                    mListener.onLocationChanged(aMapLocation);
                    //添加图钉
                    //  aMap.addMarker(getMarkerOptions(amapLocation));
                    //获取定位信息
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(aMapLocation.getCountry() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getCity() + ""
                            + aMapLocation.getProvince() + ""
                            + aMapLocation.getDistrict() + ""
                            + aMapLocation.getStreet() + ""
                            + aMapLocation.getStreetNum());
                    //Toast.makeText(getContext(), buffer.toString(), Toast.LENGTH_LONG).show();
                    city1 = aMapLocation.getCity();
                    double longitude = aMapLocation.getLongitude();
                    double latitude = aMapLocation.getLatitude();
                    SPUtils.putString(getActivity(),"map","jingdu",longitude+"");
                    SPUtils.putString(getActivity(),"map","weidu",latitude+"");
                    //Toast.makeText(getContext(), ""+city1+"11", Toast.LENGTH_SHORT).show();
                    city.setText(city1 + "");
                    isFirstLoc = false;
                }


            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
                Toast.makeText(getContext(), "定位失败", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        mListener = null;
    }




    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }

    private void location() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    //权限
/*
    private static final int RC_CAMERA_AND_RECORD_AUDIO = 10000;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
    *//**
     * 去申请权限
     *//*
    @AfterPermissionGranted(RC_CAMERA_AND_RECORD_AUDIO)
    private void requestPermissions() {
        String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE};

        //判断有没有权限
        if (EasyPermissions.hasPermissions(getContext(), perms)) {
            // 如果有权限了,
            // doing something就做你该做的事情
            openCamera();
        } else {
            // 如果没有权限, 就去申请权限
            // this: 上下文
            // Dialog显示的正文
            // RC_CAMERA_AND_RECORD_AUDIO 请求码, 用于回调的时候判断是哪次申请
            // perms 就是你要申请的权限
            EasyPermissions.requestPermissions(getActivity(), "该页面需要您开启定位,否则可能使用不了", RC_CAMERA_AND_RECORD_AUDIO, perms);
        }
    }
    *//**
     * 权限申请成功的回调
     *
     * @param requestCode 申请权限时的请求码
     * @param perms       申请成功的权限集合
     *//*
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.i("aaaa", "onPermissionsGranted: ");
        if (requestCode != RC_CAMERA_AND_RECORD_AUDIO) {
            return;
        }
        for (int i = 0; i < perms.size(); i++) {
            if (perms.get(i).equals(perms.get(i))) {
                Log.i("aaaa", "onPermissionsGranted: " + "相机权限成功");
                openCamera();

            }*//* else if (perms.get(i).equals(Manifest.permission.RECORD_AUDIO)) {
                Log.i("aaaa", "onPermissionsGranted: " + "录制音频权限成功");
            }*//*
        }
    }
    *//**
     * 权限申请拒绝的回调
     *
     * @param requestCode 申请权限时的请求码
     * @param perms       申请拒绝的权限集合
     *//*
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.i("aaaa", "onPermissionsDenied: ");

        if (requestCode != RC_CAMERA_AND_RECORD_AUDIO) {
            return;
        }

        for (int i = 0; i < perms.size(); i++) {
            if (perms.get(i).equals(perms.get(i))) {
                Log.i("aaaa", "onPermissionsDenied: " + "地图权限拒绝");
            } *//*else if (perms.get(i).equals(Manifest.permission.RECORD_AUDIO)) {
                Log.i("aaaa", "onPermissionsDenied: " + "地图权限拒绝");
            }*//*
        }

        //如果有一些权限被永久的拒绝, 就需要转跳到 设置-->应用-->对应的App下去开启权限
        if (EasyPermissions.somePermissionPermanentlyDenied(getActivity(), perms)) {
            new AppSettingsDialog.Builder(getActivity())
                    .setTitle("权限已经被您拒绝")
                    .setRationale("如果不打开权限则无法使用该功能,点击确定去打开权限")
                    .setRequestCode(10001)//用于onActivityResult回调做其它对应相关的操作
                    .build()
                    .show();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10001) {
            Toast.makeText(getContext(), "从开启权限的页面转跳回来", Toast.LENGTH_SHORT).show();
        }
    }
    private void openCamera() {
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        if (aMap == null) {
            aMap = mapView.getMap();
            //设置显示定位按钮 并且可以点击
            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource(this);//设置了定位的监听
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
        }
        location();
    }*/
   /* protected String[] needPermissions = {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE
            };
    private static final int PERMISSON_REQUESTCODE = 0;
    private boolean isNeedCheck = true;
    *//**
     * 判断是否需要检测，防止不停的弹框
     *//*
    @Override
    public void onResume() {
        super.onResume();
        if(isNeedCheck){
            checkPermissions(needPermissions);
        }
    }
    private void openCamera() {
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        if (aMap == null) {
            aMap = mapView.getMap();
            //设置显示定位按钮 并且可以点击
            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource(this);//设置了定位的监听
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
        }
        location();
    }

    *//**
     *
     * @param
     * @since 2.5.0
     *
     *//*
    private void checkPermissions(String... permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(permissions);
         if (null != needRequestPermissonList
                && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions(getActivity(),
                    needRequestPermissonList.toArray(
                            new String[needRequestPermissonList.size()]),
                    PERMISSON_REQUESTCODE);
        }
    }
    *//**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     *
     *//*
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(getContext(),
                    perm) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.shouldShowRequestPermissionRationale(
                    getActivity(), perm)) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;

    }
    *//**
     * 检测是否说有的权限都已经授权
     * @param grantResults
     * @return
     * @since 2.5.0
     *
     *//*
    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

            openCamera();
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                showMissingPermissionDialog();
                isNeedCheck = false;
            }
        }
    }
    *//**

     * 显示提示信息

     *

     * @since 2.5.0

     *

     *//*

    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.notifyTitle);
        builder.setMessage(R.string.notifyMsg);
        // 拒绝, 退出应用
        builder.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });



        builder.setPositiveButton(R.string.setting,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAppSettings();
                    }
                });
        builder.setCancelable(false);
        builder.show();
    }
    *//**

     *  启动应用的设置

     *

     * @since 2.5.0

     *

     *//*

    private void startAppSettings() {

        Intent intent = new Intent(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);

        intent.setData(Uri.parse("package:" + getActivity().getPackageName()));

        startActivity(intent);
        if (aMap == null) {
            aMap = mapView.getMap();
            //设置显示定位按钮 并且可以点击
            UiSettings settings = aMap.getUiSettings();
            aMap.setLocationSource(this);//设置了定位的监听
            // 是否显示定位按钮
            settings.setMyLocationButtonEnabled(true);
            aMap.setMyLocationEnabled(true);//显示定位层并且可以触发定位,默认是flase
        }
        location();

    }



    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            getActivity().finish();
            return true;
        }
        return getActivity().onKeyDown(keyCode, event);
    }
*/

    String[] needPermissions = {
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE
            };

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

}
