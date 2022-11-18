package dev.webfx.platform.windowhistory.spi.impl.gwt;

import dev.webfx.platform.windowhistory.spi.impl.gwt.jsinterop.Window;
import dev.webfx.platform.json.spi.impl.gwt.GwtJsonObject;
import dev.webfx.platform.json.ReadOnlyJsonObject;
import dev.webfx.platform.windowhistory.spi.impl.web.JsWindowHistory;
import dev.webfx.platform.async.Handler;
import java.util.function.Function;

/**
 * @author Bruno Salmon
 */
public final class GwtJsWindowHistory implements JsWindowHistory {

    public GwtJsWindowHistory() {
    }

    @Override
    public int length() {
        return Window.history.length;
    }

    @Override
    public void go(int offset) {
        Window.history.go(offset);
    }

    @Override
    public final native boolean supportsStates() /*-{
        return typeof window.history.pushState === 'function';
    }-*/;

    @Override
    public ReadOnlyJsonObject state() {
        return Window.history.state.cast();
    }

    @Override
    public void pushState(Object stateObj, String title, String url) {
        Window.history.pushState((GwtJsonObject) stateObj, title, url);
    }

    @Override
    public void replaceState(Object stateObj, String title, String url) {
        Window.history.replaceState((GwtJsonObject) stateObj, title, url);
    }

    @Override
    public void onPopState(Handler<ReadOnlyJsonObject> stateListener) {
        Window.onpopstate = event -> stateListener.handle((GwtJsonObject) event.state);
    }

    @Override
    public void onBeforeUnload(Function<ReadOnlyJsonObject, String> listener) {
        Window.onbeforeunload = event -> listener.apply((GwtJsonObject) event);
    }

}
