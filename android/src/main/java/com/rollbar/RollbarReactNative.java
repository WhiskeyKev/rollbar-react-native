package com.rollbar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.content.Context;

import com.rollbar.android.Rollbar;
import com.rollbar.api.payload.data.Level;
import com.rollbar.notifier.config.Config;
import com.rollbar.notifier.config.ConfigBuilder;
import com.rollbar.notifier.config.ConfigProvider;

public class RollbarReactNative extends ReactContextBaseJavaModule {
  private static final String REACT_NATIVE = "react-native";
  private static final String NOTIFIER_VERSION = "0.1.0";
  private ReactContext reactContext;

  public static ReactPackage getPackage() {
    return new RollbarReactNativePackage();
  }

  public RollbarReactNative(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  public static void init(Context context, String accessToken, String environment) {
    Rollbar.init(context, accessToken, environment, true, false, new ConfigProvider() {
      @Override
      public Config provide(ConfigBuilder builder) {
        return builder
          .framework(REACT_NATIVE)
          .build();
      }
    });
  }

  /**
   * Record a critical error.
   *
   * @param error the error.
   */
  public static void critical(Throwable error) {
    critical(error, null, null);
  }

  /**
   * Record a critical error with human readable description.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void critical(Throwable error, String description) {
    critical(error, null, description);
  }

  /**
   * Record a critical error with extra information attached.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void critical(Throwable error, Map<String, Object> custom) {
    critical(error, custom, null);
  }

  /**
   * Record a critical message.
   *
   * @param message the message.
   */
  public static void critical(String message) {
    critical(null, null, message);
  }

  /**
   * Record a critical message with extra information attached.
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void critical(String message, Map<String, Object> custom) {
    critical(null, custom, message);
  }

  /**
   * Record a critical error with custom parameters and human readable description.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void critical(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, Level.CRITICAL);
  }

  /**
   * Record an error.
   *
   * @param error the error.
   */
  public static void error(Throwable error) {
    error(error, null, null);
  }

  /**
   * Record an error with human readable description.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void error(Throwable error, String description) {
    error(error, null, description);
  }

  /**
   * Record an error with extra information attached.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void error(Throwable error, Map<String, Object> custom) {
    error(error, custom, null);
  }

  /**
   * Record an error message.
   *
   * @param message the message.
   */
  public static void error(String message) {
    error(null, null, message);
  }

  /**
   * Record a error message with extra information attached.
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void error(String message, Map<String, Object> custom) {
    error(null, custom, message);
  }

  /**
   * Record an error with custom parameters and human readable description.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void error(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, Level.ERROR);
  }

  /**
   * Record an error as a warning.
   *
   * @param error the error.
   */
  public static void warning(Throwable error) {
    warning(error, null, null);
  }

  /**
   * Record a warning with human readable description.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void warning(Throwable error, String description) {
    warning(error, null, description);
  }

  /**
   * Record a warning error with extra information attached.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void warning(Throwable error, Map<String, Object> custom) {
    warning(error, custom, null);
  }

  /**
   * Record a warning message.
   *
   * @param message the message.
   */
  public static void warning(String message) {
    warning(null, null, message);
  }

  /**
   * Record a warning message with extra information attached.
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void warning(String message, Map<String, Object> custom) {
    warning(null, custom, message);
  }

  /**
   * Record a warning error with custom parameters and human readable description.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void warning(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, Level.WARNING);
  }

  /**
   * Record an error as an info.
   *
   * @param error the error.
   */
  public static void info(Throwable error) {
    info(error, null, null);
  }

  /**
   * Record an info error with human readable description.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void info(Throwable error, String description) {
    info(error, null, description);
  }

  /**
   * Record an info error with extra information attached.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void info(Throwable error, Map<String, Object> custom) {
    info(error, custom, null);
  }

  /**
   * Record an informational message.
   *
   * @param message the message.
   */
  public static void info(String message) {
    info(null, null, message);
  }

  /**
   * Record an informational message with extra information attached.
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void info(String message, Map<String, Object> custom) {
    info(null, custom, message);
  }

  /**
   * Record an info error with custom parameters and human readable description.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void info(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, Level.INFO);
  }

  /**
   * Record an error as debugging information.
   *
   * @param error the error.
   */
  public static void debug(Throwable error) {
    debug(error, null, null);
  }

  /**
   * Record a debug error with human readable description.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void debug(Throwable error, String description) {
    debug(error, null, description);
  }

  /**
   * Record a debug error with extra information attached.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void debug(Throwable error, Map<String, Object> custom) {
    debug(error, custom, null);
  }

  /**
   * Record a debugging message.
   *
   * @param message the message.
   */
  public static void debug(String message) {
    debug(null, null, message);
  }

  /**
   * Record a debugging message with extra information attached.
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void debug(String message, Map<String, Object> custom) {
    debug(null, custom, message);
  }

  /**
   * Record a debug error with custom parameters and human readable description.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void debug(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, Level.DEBUG);
  }

  /**
   * Log an error at the level returned by {@link com.rollbar.notifier.Rollbar#level}.
   *
   * @param error the error.
   */
  public static void log(Throwable error) {
    log(error, null, null, null);
  }

  /**
   * Record an error with human readable description at the default level returned by {@link
   * com.rollbar.notifier.Rollbar#level}.
   *
   * @param error       the error.
   * @param description human readable description of error.
   */
  public static void log(Throwable error, String description) {
    log(error, null, description, null);
  }

  /**
   * Record an error with extra information attached at the default level returned by {@link
   * com.rollbar.notifier.Rollbar#level}.
   *
   * @param error  the error.
   * @param custom the extra information.
   */
  public static void log(Throwable error, Map<String, Object> custom) {
    log(error, custom, null, null);
  }

  /**
   * Record an error with extra information attached at the level specified.
   *
   * @param error  the error.
   * @param custom the extra information.
   * @param level  the level.
   */
  public static void log(Throwable error, Map<String, Object> custom, Level level) {
    log(error, custom, null, level);
  }

  /**
   * Log an error at level specified.
   *
   * @param error the error.
   * @param level the level of the error.
   */
  public static void log(Throwable error, Level level) {
    log(error, null, null, level);
  }

  /**
   * Record a debug error with human readable description at the specified level.
   *
   * @param error       the error.
   * @param description human readable description of error.
   * @param level       the level.
   */
  public static void log(Throwable error, String description, Level level) {
    log(error, null, description, level);
  }

  /**
   * Record an error with custom parameters and human readable description at the default level
   * returned by {@link com.rollbar.notifier.Rollbar#level}.
   *
   * @param error       the error.
   * @param custom      the custom data.
   * @param description the human readable description of error.
   */
  public static void log(Throwable error, Map<String, Object> custom, String description) {
    log(error, custom, description, null);
  }

  /**
   * Record a debugging message at the level returned by {@link com.rollbar.notifier.Rollbar#level} (WARNING unless level
   * is overridden).
   *
   * @param message the message.
   */
  public static void log(String message) {
    log(null, null, message, null);
  }

  /**
   * Record a message with extra information attached at the default level returned by {@link
   * com.rollbar.notifier.Rollbar#level}, (WARNING unless level overridden).
   *
   * @param message the message.
   * @param custom  the extra information.
   */
  public static void log(String message, Map<String, Object> custom) {
    log(null, custom, message, null);
  }

  /**
   * Record a message at the level specified.
   *
   * @param message the message.
   * @param level   the level.
   */
  public static void log(String message, Level level) {
    log(null, null, message, level);
  }

  /**
   * Record a message with extra information attached at the specified level.
   *
   * @param message the message.
   * @param custom  the extra information.
   * @param level   the level.
   */
  public static void log(String message, Map<String, Object> custom, Level level) {
    log(null, custom, message, level);
  }

  /**
   * Record an error or message with extra data at the level specified. At least ene of `error` or
   * `description` must be non-null. If error is null, `description` will be sent as a message. If
   * error is non-null, description will be sent as the description of the error. Custom data will
   * be attached to message if the error is null.
   *
   * @param error       the error (if any).
   * @param custom      the custom data (if any).
   * @param description the description of the error, or the message to send.
   * @param level       the level to send it at.
   */
  public static void log(final Throwable error, final Map<String, Object> custom, final String description, final Level level) {
    Rollbar.instance().log(error, custom, description, level);
  }

  public static Rollbar instance() {
    return Rollbar.instance();
  }

  @Override
  public String getName() {
    return "RollbarReactNative";
  }

  @ReactMethod
  public void init(ReadableMap options) {
    final String environment = options.hasKey("environment") ? options.getString("environment") : null;
    if (environment != null) {
      Rollbar.instance().configure(new ConfigProvider() {
        @Override
        public Config provide(ConfigBuilder builder) {
          return builder
            .environment(environment)
            .build();
        }
      });
    }
  }

	@ReactMethod
  public void setPerson(ReadableMap personInfo) {
      String userId = personInfo.hasKey("id") ? personInfo.getString("id") : null;
      String email = personInfo.hasKey("email") ? personInfo.getString("email") : null;
      String name = personInfo.hasKey("name") ? personInfo.getString("name") : null;
      Rollbar.instance().setPersonData(userId, name, email);
  }

  @ReactMethod
  public void clearPerson() {
      Rollbar.instance().clearPersonData();
  }
}

class RollbarReactNativePackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
      return Arrays.<NativeModule>asList(new RollbarReactNative(reactContext));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
    }
}