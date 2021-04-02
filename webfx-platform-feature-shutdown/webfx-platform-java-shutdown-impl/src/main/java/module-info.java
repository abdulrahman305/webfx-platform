// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.shutdown.impl {

    // Direct dependencies modules
    requires webfx.platform.shared.shutdown;

    // Exported packages
    exports dev.webfx.platform.java.services.shutdown.spi.impl;

    // Provided services
    provides dev.webfx.platform.shared.services.shutdown.spi.ShutdownProvider with dev.webfx.platform.java.services.shutdown.spi.impl.JavaShutdownProvider;

}