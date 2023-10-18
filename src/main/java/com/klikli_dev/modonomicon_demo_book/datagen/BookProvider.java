/*
 * SPDX-FileCopyrightText: 2022 klikli-dev
 *
 * SPDX-License-Identifier: MIT
 */

package com.klikli_dev.modonomicon_demo_book.datagen;

import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;

public class BookProvider extends com.klikli_dev.modonomicon.api.datagen.BookProvider {

    public BookProvider(PackOutput packOutput, String modid, LanguageProvider lang, LanguageProvider... translations) {
        super("new_horizon_tutorials_book", packOutput, modid, lang, translations);
    }

    @Override
    protected BookModel generateBook() {

        this.lang().add(this.context().bookName(), "门扉于新视野");
        this.lang().add(this.context().bookTooltip(), "一本用于帮助你理解挖砍:新视野的书籍。");

        BookCategoryModel tutorialsCategory = new TutorialsCategoryProvider(this, "tutorials_category").generate();


        return BookModel.create(
                        this.modLoc(this.context().bookId()),
                        this.context().bookName()
                )
                .withTooltip(this.context().bookTooltip())
                .withGenerateBookItem(true)
                .withModel(new ResourceLocation("modonomicon:modonomicon_red"))
                .withCreativeTab(new ResourceLocation("modonomicon", "modonomicon"))
                .withCategories(
                        tutorialsCategory
                );
    }

    @Override
    protected void registerDefaultMacros() {
        //currently we have no macros
    }
}
