// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.shutdown {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.util;

    // Exported packages
    exports dev.webfx.platform.shared.services.shutdown;
    exports dev.webfx.platform.shared.services.shutdown.spi;
    exports dev.webfx.platform.shared.services.shutdown.spi.impl;

    // Used services
    uses dev.webfx.platform.shared.services.shutdown.spi.ShutdownProvider;

}