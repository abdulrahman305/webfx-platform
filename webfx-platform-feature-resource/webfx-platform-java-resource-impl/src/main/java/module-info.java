// File managed by WebFX (DO NOT EDIT MANUALLY)

module webfx.platform.java.resource.impl {

    // Direct dependencies modules
    requires java.base;
    requires webfx.platform.shared.resource;

    // Exported packages
    exports dev.webfx.platform.java.services.resource.spi.impl;

    // Provided services
    provides dev.webfx.platform.shared.services.resource.spi.ResourceServiceProvider with dev.webfx.platform.java.services.resource.spi.impl.JavaResourceServiceProvider;

}