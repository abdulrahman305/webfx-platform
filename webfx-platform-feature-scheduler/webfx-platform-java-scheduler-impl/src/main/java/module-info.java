// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.scheduler.impl {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.log;
    requires webfx.platform.shared.scheduler;

    // Exported packages
    exports dev.webfx.platform.java.services.scheduler.spi.impl;

    // Provided services
    provides dev.webfx.platform.shared.services.scheduler.spi.SchedulerProvider with dev.webfx.platform.java.services.scheduler.spi.impl.JavaSchedulerProvider;

}