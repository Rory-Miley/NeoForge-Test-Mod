package net.rpm.canabacraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rpm.canabacraft.CanabaCraft;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CanabaCraft.MOD_ID);


    public static final Supplier<CreativeModeTab> CANABACRAFT_ITEMS_TAB = CREATIVE_MODE_TAB.register("canabacraft_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BUD.get()))
                    .title(Component.translatable("creativetab.canabacraft.canabacraft_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.JOINT);
                        output.accept(ModItems.ROCHE);
                        output.accept(ModItems.SKIN);
                        output.accept(ModItems.BUD);
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
