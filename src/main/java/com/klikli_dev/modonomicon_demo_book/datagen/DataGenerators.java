// SPDX-FileCopyrightText: 2022 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.modonomicon_demo_book.datagen;

import com.klikli_dev.modonomicon_demo_book.ModonomiconDemoBook;
import com.klikli_dev.modonomicon_demo_book.datagen.lang.ZhCnProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        var zhCnProvider = new ZhCnProvider(generator.getPackOutput(), ModonomiconDemoBook.MODID);

        generator.addProvider(event.includeServer(), new BookProvider(generator.getPackOutput(), ModonomiconDemoBook.MODID,
                zhCnProvider
        ));

        generator.addProvider(event.includeClient(), zhCnProvider);
    }

}
