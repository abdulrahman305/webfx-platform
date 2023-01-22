package dev.webfx.platform.resource.spi.impl.gwt;

import com.google.gwt.resources.client.TextResource;
import dev.webfx.platform.resource.spi.ResourceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public final class GwtResourceProvider implements ResourceProvider {

    private final List<GwtResourceBundle> bundles = new ArrayList<>();

    public void register(GwtResourceBundle bundle) {
        bundles.add(bundle);
    }

    @Override
    public String toUrl(String resourcePath, Class<?> loadingClass) {
        if (resourcePath != null) {
            // We need to return the absolute path of the resource from index.html file (the resource packages are located beside index.html)
            if (resourcePath.startsWith("/")) // If the path provided is already absolute,
                resourcePath = resourcePath.substring(1); // we just remove the first / to make that path relative to index.html
            else if (loadingClass != null) { // If the path is relative to the loading class,
                // We need to prefix the path with the location of the package at the same level of the loadingClass
                // Getting the class package name
                String fullClassName = loadingClass.getName(); // GWT doesn't support Class.getPackageName() so we get the fully qualified class name
                String packageName = fullClassName.substring(0, fullClassName.length() - loadingClass.getSimpleName().length() - 1); // and remove the class name as well as the last '.'
                // We replace all the '.' with '/' and append the relative resource path
                resourcePath = packageName.replace('.', '/') + "/" + resourcePath;
            }
        }
        return resourcePath;
    }

    @Override
    public String getText(String resourcePath) {
        for (GwtResourceBundle bundle : bundles) {
            TextResource textResource = bundle.getTextResource(resourcePath);
            if (textResource != null)
                return textResource.getText();
        }
        return null;
    }
}
