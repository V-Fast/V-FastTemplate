package org.vfast.template;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateMod implements ModInitializer {
    public static final Logger logger = LoggerFactory.getLogger("template");
    public static final String ID = "template";

    @Override
    public void onInitialize() {
        print("Template initialized");
    }

    public void print(String text) {
        logger.info("[TEMPLATE] " + text);
    }
}
