// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.shared.log.impl.simple {

    // Direct dependencies modules
    requires webfx.platform.shared.log;

    // Exported packages
    exports dev.webfx.platform.shared.services.log.spi.impl.simple;

    // Provided services
    provides dev.webfx.platform.shared.services.log.spi.LoggerProvider with dev.webfx.platform.shared.services.log.spi.impl.simple.SimpleLoggerProvider;

}