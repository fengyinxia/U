package com.junzilan.u;



import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import java.io.File;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;



public class D implements IXposedHookLoadPackage {

    private static final String CLASS0 = "com.easysay.db.DbModel.uColeegeBean.CourseDetail";//解锁课程

    private static final String CLASS = "com.easysay.module_learn.newquality.model.impl.QualityModel";//解锁课程

    private static final String CLASS1 = "com.easysay.module_learn.newquality.contract.present.VideoSalePresent";//解锁课程

    private static final String CLASS2 = "com.huahua.utils.PointManager";//解锁VIP

    private static final String CLASS3 = "com.huahua.login.model.User";//解锁VIP

    private static final String Pk = "com.easysay.japanese";//日语U学院

    private static final String Pk1 = "com.huahua.yueyu";//粤语U学院

    private static final String Pk2 = "com.easysay.french";//法语U学院

    private static final String Pk3 = "com.easysay.espanol";//西班牙语U学院

    private static final String Pk4 = "com.easysay.korean";//韩语U学院

    private static final String Pk5 = "com.huahua.testing";//普通话测试

    private static final String Pk6 = "com.huahua.learningpth";//普通话学习

    private static final String Pk7 = "com.easysay.learningpth";//普通话考试

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws
            Throwable {
        if (loadPackageParam.packageName.equals(Pk)
                || loadPackageParam.packageName.equals(Pk1)
                || loadPackageParam.packageName.equals(Pk2)
                || loadPackageParam.packageName.equals(Pk3)
                || loadPackageParam.packageName.equals(Pk4)
                || loadPackageParam.packageName.equals(Pk5)
                || loadPackageParam.packageName.equals(Pk6)
                || loadPackageParam.packageName.equals(Pk7)
        ) {
            XposedHelpers.findAndHookMethod("com.stub.StubApp", loadPackageParam.classLoader,
                    "attachBaseContext", Context.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            r();
                            Context context = (Context) param.args[0];
                            ClassLoader classLoader = context.getClassLoader();
//xxU学院系列
                            if (loadPackageParam.packageName.equals(Pk)
                                    || loadPackageParam.packageName.equals(Pk1)
                                    || loadPackageParam.packageName.equals(Pk2)
                                    || loadPackageParam.packageName.equals(Pk3)
                                    || loadPackageParam.packageName.equals(Pk4)
                            )
                                XposedHelpers.findAndHookMethod("android.app.SharedPreferencesImpl", classLoader,
                                        "getBoolean",
                                        String.class,
                                        boolean.class,
                                        new XC_MethodHook() {
                                            @Override
                                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                                File mFile = (File) XposedHelpers.getObjectField(param.thisObject, "mFile");
                                                if (!mFile.getName().equals("data_state.xml")) {
                                                    return;
                                                }
                                                String key = (String) param.args[0];
                                                if (key.equals("pro")) {
                                                    param.setResult(true);
                                                }
                                            }
                                        });
                                 if (loadPackageParam.packageName.equals(Pk))
                                 {

                                XposedHelpers.findAndHookMethod(CLASS0, classLoader, "getIsUnlock", XC_MethodReplacement.returnConstant(Boolean.TRUE));
                                XposedHelpers.findAndHookMethod(CLASS1, classLoader, "isUnlock", XC_MethodReplacement.returnConstant(true));
                                XposedHelpers.findAndHookMethod("com.easysay.module_me.ui.AboutUsActivity", classLoader,
                                             "b",
                                             new XC_MethodHook() {
                                                 @Override
                                                 protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                                                     TextView a =(TextView)XposedHelpers.getObjectField(param.thisObject,"h");
                                                     a.setText("风绕柳絮轻敲雪");
                                                     a.setTextColor(Color.parseColor("#00FFFF"));
                                                 }
                                             });
                                 }
                                if (loadPackageParam.packageName.equals(Pk1) || loadPackageParam.packageName.equals(Pk4))
                                {
                                XposedHelpers.findAndHookMethod(CLASS, classLoader, "isUnlockQualityVideo", String.class, XC_MethodReplacement.returnConstant(true));
                                 }
//普通话系列
                            if (loadPackageParam.packageName.equals(Pk5)|| loadPackageParam.packageName.equals(Pk6)|| loadPackageParam.packageName.equals(Pk7)) {
                                XposedHelpers.findAndHookMethod(CLASS2, classLoader, "getDayCanAddMaxPoint", XC_MethodReplacement.returnConstant(999999));
                                XposedHelpers.findAndHookMethod(CLASS2, classLoader, "getCurrentPoint", XC_MethodReplacement.returnConstant(888888));
                                XposedHelpers.findAndHookMethod(CLASS2, classLoader, "isProUser", XC_MethodReplacement.returnConstant(true));
                                if (loadPackageParam.packageName.equals(Pk6))
                                {
                                    XposedHelpers.findAndHookMethod(CLASS2, classLoader, "isForeverVip", XC_MethodReplacement.returnConstant(true));
                                    XposedHelpers.findAndHookMethod("com.huahua.data.ScoreDataManager",
                                            classLoader,
                                            "isPthPurchasedCourse",
                                            Context.class,
                                            String.class,
                                            XC_MethodReplacement.returnConstant(true));
                                    XposedHelpers.findAndHookMethod("com.huahua.course.bean.ClassicResult",
                                            classLoader,
                                            "getStatus",
                                            XC_MethodReplacement.returnConstant(1));
                                }
                                if (loadPackageParam.packageName.equals(Pk7)|| loadPackageParam.packageName.equals(Pk5))
                                {
                                    XposedHelpers.findAndHookMethod(CLASS3,
                                            classLoader,
                                            "getState",
                                            XC_MethodReplacement.returnConstant(2));
                                    XposedHelpers.findAndHookMethod(CLASS3,
                                            classLoader,
                                            "getVipType",
                                            XC_MethodReplacement.returnConstant(-2));
                                }
                            }
                        }
                    });
        }
    }
    public void r()
    {
        File file=new File("/sdcard/.风绕柳絮轻敲雪");
        if(!file.exists()){
            file.mkdir();
        }
    }
}



