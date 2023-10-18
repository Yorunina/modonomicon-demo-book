package com.klikli_dev.modonomicon_demo_book.datagen;

import com.klikli_dev.modonomicon.api.datagen.BookProvider;
import com.klikli_dev.modonomicon.api.datagen.CategoryProvider;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookEntryModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import com.klikli_dev.modonomicon.book.BookCategoryBackgroundParallaxLayer;
import net.minecraft.resources.ResourceLocation;

public class TutorialsCategoryProvider extends CategoryProvider {
    public TutorialsCategoryProvider(BookProvider parent, String categoryId) {
        super(parent, categoryId);
    }

    @Override
    protected String[] generateEntryMap() {
        return new String[]{
                "_______________________",
                "_______________________",
                "_______________________",
                "__f__t________________",
                "_______________________",
                "_______________________",
                "_______________________",
                "_______________________"
        };
    }

    @Override
    protected void generateEntries() {
        BookEntryModel forewordEntry = this.add(this.makeForewordEntry('f'));
//       BookEntryModel knowYourselfEntry = this.add(this.makeForewordEntry('t').withParent(forewordEntry));
    }

    @Override
    protected BookCategoryModel generateCategory() {
        this.lang().add(this.context().categoryName(), "教学");


        return BookCategoryModel.create(
                        this.modLoc(this.context().categoryId()),
                        this.context().categoryName()
                )
                .withBackgroundParallaxLayer(new BookCategoryBackgroundParallaxLayer(new ResourceLocation("modonomicon:textures/gui/parallax/flow/base.png"), 0.7f, -1.0f))
                .withBackgroundParallaxLayer(new BookCategoryBackgroundParallaxLayer(new ResourceLocation("modonomicon:textures/gui/parallax/flow/1.png"), 1.0f, -1.0f))
                .withBackgroundParallaxLayer(new BookCategoryBackgroundParallaxLayer(new ResourceLocation("modonomicon:textures/gui/parallax/flow/2.png"), 1.4f, 0.9f))
                .withIcon("minecraft:nether_star");
    }

    private BookEntryModel makeForewordEntry(char location) {
        this.context().entry("text");
        this.lang().add(this.context().entryName(), "前言");
        this.lang().add(this.context().entryDescription(), "何述于书？书叙何术？");

        this.context().page("forewordPage1");
        var forewordPageOne =
                BookTextPageModel.builder()
                        .withText(this.context().pageText())
                        .withTitle(this.context().pageTitle())
                        .build();
        this.lang().add(this.context().pageTitle(), "前言");
        this.lang().add(this.context().pageText(), """
                在本章节，将会使用最为浅显的语言向你介绍如何入门该整合包，以及该整合包的各类操作以及特点。同时，笔者也尽量将所有的废话凝练在“前言”与“结语”这两章内，以节省各位读者的精力。
                \n如果你不对本整合包的设计目的和设计原理感兴趣，可以跳过这两部分。但倘若能赏脸一读，相信内容不会令各位玩家失望。
                """);

        this.context().page("forewordPage2");
        var forewordPageTwo =
                BookTextPageModel.builder()
                        .withText(this.context().pageText())
                        .withTitle(this.context().pageTitle())
                        .build();
        this.lang().add(this.context().pageTitle(), "设计目的");
        this.lang().add(this.context().pageText(), """
                本整合包与常见的各类冒险整合包不同之处在于，摆脱了常规的“生存->维度冒险->获取装备->达成目标”的游玩顺序。通过高定制化的地图和配置，实现了无间断的战斗游玩体验，代价是舍弃了几乎所有的自由生存内容。
                \n关于这部分的取舍，其实是有经过深思熟虑的。类如宝藏猎人或是放逐之路这种整合包，虽然其也包含有高定制化的副本内容，但笔者在体验过程中发现，大部分此类整合中，无聊的生存与玩家想体验的战斗的比例过于失衡。
                \n因此，舍弃了常规生存，反而是更容易让玩家的注意力集中在整合的特色上，并非是一样缺点。更重要的是，整合包的制作必将走向高定制化的未来，基于地图的整合包无疑是一个重要的发展方向。
                \n本包即是一次极其富有意义的尝试。
                """);

        this.context().page("forewordPage3");
        var forewordPageThree =
                BookTextPageModel.builder()
                        .withText(this.context().pageText())
                        .build();
        this.lang().add(this.context().pageText(), """
                本整合中，玩家将会在多个不同等级的同一个副本地图中完成任务。最终通过任务获得的赏金道具，合成永恒之门，经历战斗后即可获取奖励离开副本。
                \n这里所提到的任务，即是一些与原版玩法相关的内容。当然，其中也包含了一些类似小游戏般的设计。比如探索任务，它是基于对地图上各类资源的收集而制成的；钓鱼任务，则是根据原版钓鱼结合幸运制成的。这些玩法在继承原版玩法的基础上，包含了一些改动以新鲜玩家感官。
                \n当然，这之中许多设计，都在鼓励玩家进行“战前准备”。这是因为笔者将MC的战斗更多的看做是一种“运营”。限制玩家进入副本所能携带的物品，同时在副本中提供种类丰富但混杂的资源获取途径，以鼓励玩家进行战前规划和随机应变，提高整体的副本清理效率。
                \n同时这也导向了玩家的职责方向分化。相比于技能的强制限制，这种通过有限资源的职责分类，更能够发挥玩家对于该职业资源运转的理解，提高整个流程可发掘的内容量。
                """);

        return this.entry(location)
                .withIcon("minecraft:wood")
                .withPages(
                        forewordPageOne,
                        forewordPageTwo,
                        forewordPageThree
                );
    }
}
