/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.modonomicon_demo_book.datagen.lang;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ZhCnProvider extends LanguageProvider {

    public ZhCnProvider(PackOutput packOutput, String modid) {
        super(packOutput, modid, "zh_cn");
    }

    protected void addTranslations() {
        //Here you can do your normal translations
    }
}