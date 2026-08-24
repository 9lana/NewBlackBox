package app.viscount.loader.fake.hook;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import app.viscount.loader.BlackBoxCore;
import app.viscount.loader.fake.delegate.AppInstrumentation;

import app.viscount.loader.fake.service.HCallbackProxy;
import app.viscount.loader.fake.service.IAccessibilityManagerProxy;
import app.viscount.loader.fake.service.IAccountManagerProxy;
import app.viscount.loader.fake.service.IActivityClientProxy;
import app.viscount.loader.fake.service.IActivityManagerProxy;
import app.viscount.loader.fake.service.IActivityTaskManagerProxy;
import app.viscount.loader.fake.service.IAlarmManagerProxy;
import app.viscount.loader.fake.service.IAppOpsManagerProxy;
import app.viscount.loader.fake.service.IAppWidgetManagerProxy;
import app.viscount.loader.fake.service.IAttributionSourceProxy;
import app.viscount.loader.fake.service.IAutofillManagerProxy;
import app.viscount.loader.fake.service.ISensitiveContentProtectionManagerProxy;
import app.viscount.loader.fake.service.ISettingsSystemProxy;
import app.viscount.loader.fake.service.IConnectivityManagerProxy;
import app.viscount.loader.fake.service.ISystemSensorManagerProxy;
import app.viscount.loader.fake.service.IContentProviderProxy;
import app.viscount.loader.fake.service.IXiaomiAttributionSourceProxy;
import app.viscount.loader.fake.service.IXiaomiSettingsProxy;
import app.viscount.loader.fake.service.IXiaomiMiuiServicesProxy;
import app.viscount.loader.fake.service.IDnsResolverProxy;
import app.viscount.loader.fake.service.IContextHubServiceProxy;
import app.viscount.loader.fake.service.IDeviceIdentifiersPolicyProxy;
import app.viscount.loader.fake.service.IDevicePolicyManagerProxy;
import app.viscount.loader.fake.service.IDisplayManagerProxy;
import app.viscount.loader.fake.service.IFingerprintManagerProxy;
import app.viscount.loader.fake.service.IGraphicsStatsProxy;
import app.viscount.loader.fake.service.IJobServiceProxy;
import app.viscount.loader.fake.service.ILauncherAppsProxy;
import app.viscount.loader.fake.service.ILocationManagerProxy;
import app.viscount.loader.fake.service.IMediaRouterServiceProxy;
import app.viscount.loader.fake.service.IMediaSessionManagerProxy;
import app.viscount.loader.fake.service.IAudioServiceProxy;
import app.viscount.loader.fake.service.ISensorPrivacyManagerProxy;
import app.viscount.loader.fake.service.ContentResolverProxy;
import app.viscount.loader.fake.service.IMiuiSecurityManagerProxy;
import app.viscount.loader.fake.service.SystemLibraryProxy;
import app.viscount.loader.fake.service.ReLinkerProxy;
import app.viscount.loader.fake.service.MediaRecorderProxy;
import app.viscount.loader.fake.service.NetworkPermissionCompat;
import app.viscount.loader.fake.service.AudioRecordProxy;
import app.viscount.loader.fake.service.MediaRecorderClassProxy;
import app.viscount.loader.fake.service.SQLiteDatabaseProxy;
import app.viscount.loader.fake.service.ClassLoaderProxy;
import app.viscount.loader.fake.service.FileSystemProxy;
import app.viscount.loader.fake.service.GmsProxy;
import app.viscount.loader.fake.service.LevelDbProxy;
import app.viscount.loader.fake.service.DeviceIdProxy;
import app.viscount.loader.fake.service.GoogleAccountManagerProxy;
import app.viscount.loader.fake.service.AuthenticationProxy;
import app.viscount.loader.fake.service.AndroidIdProxy;
import app.viscount.loader.fake.service.AudioPermissionProxy;
import app.viscount.loader.fake.service.NetworkPermissionCompat;

import app.viscount.loader.fake.service.INetworkManagementServiceProxy;
import app.viscount.loader.fake.service.INotificationManagerProxy;
import app.viscount.loader.fake.service.IPackageManagerProxy;
import app.viscount.loader.fake.service.IPermissionManagerProxy;
import app.viscount.loader.fake.service.IPersistentDataBlockServiceProxy;
import app.viscount.loader.fake.service.IPhoneSubInfoProxy;
import app.viscount.loader.fake.service.IPowerManagerProxy;
import app.viscount.loader.fake.service.ApkAssetsProxy;
import app.viscount.loader.fake.service.ResourcesManagerProxy;
import app.viscount.loader.fake.service.IShortcutManagerProxy;
import app.viscount.loader.fake.service.IStorageManagerProxy;
import app.viscount.loader.fake.service.IStorageStatsManagerProxy;
import app.viscount.loader.fake.service.ISystemUpdateProxy;
import app.viscount.loader.fake.service.ITelephonyManagerProxy;
import app.viscount.loader.fake.service.ITelephonyRegistryProxy;
import app.viscount.loader.fake.service.IUserManagerProxy;
import app.viscount.loader.fake.service.IVibratorServiceProxy;
import app.viscount.loader.fake.service.IVpnManagerProxy;
import app.viscount.loader.fake.service.IWifiManagerProxy;
import app.viscount.loader.fake.service.IWifiScannerProxy;
import app.viscount.loader.fake.service.IWindowManagerProxy;
import app.viscount.loader.fake.service.context.ContentServiceStub;
import app.viscount.loader.fake.service.context.RestrictionsManagerStub;
import app.viscount.loader.fake.service.libcore.OsStub;
import app.viscount.loader.utils.Slog;
import app.viscount.loader.utils.compat.BuildCompat;
import app.viscount.loader.fake.service.ISettingsProviderProxy;
import app.viscount.loader.fake.service.FeatureFlagUtilsProxy;
import app.viscount.loader.fake.service.WorkManagerProxy;



public class HookManager {
    public static final String TAG = "HookManager";

    private static final HookManager sHookManager = new HookManager();

    private final Map<Class<?>, IInjectHook> mInjectors = new HashMap<>();

    public static HookManager get() {
        return sHookManager;
    }

    public void init() {
        if (BlackBoxCore.get().isBlackProcess() || BlackBoxCore.get().isServerProcess()) {
            addInjector(new IDisplayManagerProxy());
            addInjector(new OsStub());
            addInjector(new IActivityManagerProxy());
            addInjector(new IPackageManagerProxy());
            addInjector(new ITelephonyManagerProxy());
            addInjector(new HCallbackProxy());
            addInjector(new IAppOpsManagerProxy());
            addInjector(new INotificationManagerProxy());
            addInjector(new IAlarmManagerProxy());
            addInjector(new IAppWidgetManagerProxy());
            addInjector(new ContentServiceStub());
            addInjector(new IWindowManagerProxy());
            addInjector(new IUserManagerProxy());
            addInjector(new RestrictionsManagerStub());
            addInjector(new IMediaSessionManagerProxy());
            addInjector(new IAudioServiceProxy());
            addInjector(new ISensorPrivacyManagerProxy());
            addInjector(new ContentResolverProxy());
            addInjector(new SystemLibraryProxy());
            addInjector(new ReLinkerProxy());
            addInjector(new WorkManagerProxy());
            addInjector(new MediaRecorderProxy());
            addInjector(new AudioRecordProxy());
            addInjector(new IMiuiSecurityManagerProxy());
            addInjector(new ISettingsProviderProxy());
            addInjector(new FeatureFlagUtilsProxy());
            addInjector(new MediaRecorderClassProxy());
            addInjector(new SQLiteDatabaseProxy());
            addInjector(new ClassLoaderProxy());
            addInjector(new FileSystemProxy());
            addInjector(new GmsProxy());
            addInjector(new LevelDbProxy());
            addInjector(new DeviceIdProxy());
            addInjector(new GoogleAccountManagerProxy());
            addInjector(new AuthenticationProxy());
            addInjector(new AndroidIdProxy());
            addInjector(new AudioPermissionProxy());
            addInjector(new ILocationManagerProxy());
            addInjector(new IStorageManagerProxy());
            addInjector(new ILauncherAppsProxy());
            addInjector(new IJobServiceProxy());
            addInjector(new IAccessibilityManagerProxy());
            addInjector(new ITelephonyRegistryProxy());
            addInjector(new IDevicePolicyManagerProxy());
            addInjector(new IAccountManagerProxy());
            addInjector(new NetworkPermissionCompat());
            addInjector(new IConnectivityManagerProxy());
            addInjector(new IDnsResolverProxy());
                    addInjector(new IAttributionSourceProxy());
        addInjector(new IContentProviderProxy());
        addInjector(new ISettingsSystemProxy());
        addInjector(new ISystemSensorManagerProxy());
        
        
        addInjector(new IXiaomiAttributionSourceProxy());
        addInjector(new IXiaomiSettingsProxy());
        addInjector(new IXiaomiMiuiServicesProxy());
            addInjector(new IPhoneSubInfoProxy());
            addInjector(new IMediaRouterServiceProxy());
            addInjector(new IPowerManagerProxy());
            addInjector(new IContextHubServiceProxy());
            
            addInjector(new IVibratorServiceProxy());
            addInjector(new IPersistentDataBlockServiceProxy());
            addInjector(AppInstrumentation.get());
            
            addInjector(new IWifiManagerProxy());
            addInjector(new IWifiScannerProxy());
            addInjector(new ApkAssetsProxy());
            addInjector(new ResourcesManagerProxy());
            
            if (BuildCompat.isS()) {
                addInjector(new IActivityClientProxy(null));
                addInjector(new IVpnManagerProxy());
            }
            
            if (BuildCompat.isS()) {
                addInjector(new ISensitiveContentProtectionManagerProxy());
            }
            
            if (BuildCompat.isR()) {
                addInjector(new IPermissionManagerProxy());
            }
            
            if (BuildCompat.isQ()) {
                addInjector(new IActivityTaskManagerProxy());
            }
            
            if (BuildCompat.isPie()) {
                addInjector(new ISystemUpdateProxy());
            }
            
            if (BuildCompat.isOreo()) {
                addInjector(new IAutofillManagerProxy());
                addInjector(new IDeviceIdentifiersPolicyProxy());
                addInjector(new IStorageStatsManagerProxy());
            }
            
            if (BuildCompat.isN_MR1()) {
                addInjector(new IShortcutManagerProxy());
            }
            
            if (BuildCompat.isN()) {
                addInjector(new INetworkManagementServiceProxy());
            }
            
            if (BuildCompat.isM()) {
                addInjector(new IFingerprintManagerProxy());
                addInjector(new IGraphicsStatsProxy());
            }
            
            if (BuildCompat.isL()) {
                addInjector(new IJobServiceProxy());
            }
        }
        injectAll();
    }

    public void checkEnv(Class<?> clazz) {
        IInjectHook iInjectHook = mInjectors.get(clazz);
        if (iInjectHook != null && iInjectHook.isBadEnv()) {
            Log.d(TAG, "checkEnv: " + clazz.getSimpleName() + " is bad env");
            iInjectHook.injectHook();
        }
    }

    public void checkAll() {
        for (Class<?> aClass : mInjectors.keySet()) {
            IInjectHook iInjectHook = mInjectors.get(aClass);
            if (iInjectHook != null && iInjectHook.isBadEnv()) {
                Log.d(TAG, "checkEnv: " + aClass.getSimpleName() + " is bad env");
                iInjectHook.injectHook();
            }
        }
    }

    void addInjector(IInjectHook injectHook) {
        mInjectors.put(injectHook.getClass(), injectHook);
    }

    void injectAll() {
        for (IInjectHook value : mInjectors.values()) {
            try {
                Slog.d(TAG, "hook: " + value);
                value.injectHook();
            } catch (Exception e) {
                Slog.d(TAG, "hook error: " + value);
                
                handleHookError(value, e);
            }
        }
    }

    
    private void handleHookError(IInjectHook hook, Exception e) {
        String hookName = hook.getClass().getSimpleName();
        
        
        Slog.e(TAG, "Hook failed: " + hookName + " - " + e.getMessage(), e);
        
        
        if (hookName.contains("ActivityManager") || 
            hookName.contains("PackageManager") ||
            hookName.contains("WebView") ||
            hookName.contains("ContentProvider")) {
            
            Slog.w(TAG, "Critical hook failed: " + hookName + ", attempting recovery");
            
            try {
                
                if (hook.isBadEnv()) {
                    Slog.d(TAG, "Attempting to recover hook: " + hookName);
                    hook.injectHook();
                }
            } catch (Exception recoveryException) {
                Slog.e(TAG, "Hook recovery failed: " + hookName, recoveryException);
            }
        }
    }

    
    public boolean areCriticalHooksInstalled() {
        String[] criticalHooks = {
            "IActivityManagerProxy",
            "IPackageManagerProxy",
            "IContentProviderProxy"
        };
        
        for (String hookName : criticalHooks) {
            boolean found = false;
            for (Class<?> hookClass : mInjectors.keySet()) {
                if (hookClass.getSimpleName().equals(hookName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Slog.w(TAG, "Critical hook missing: " + hookName);
                return false;
            }
        }
        
        Slog.d(TAG, "All critical hooks are installed");
        return true;
    }

    
    public void reinitializeHooks() {
        Slog.d(TAG, "Reinitializing all hooks");
        
        
        mInjectors.clear();
        
        
        init();
        
        Slog.d(TAG, "Hook reinitialization completed");
    }
}
