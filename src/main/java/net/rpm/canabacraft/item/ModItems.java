package net.rpm.canabacraft.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rpm.canabacraft.CanabaCraft;

public class ModItems {
    //Makes a list of the Items you want to create to add to the modloader and classifies them under your MOD_ID
    // for access to the API for other mods and such
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CanabaCraft.MOD_ID);

    // register the joint item as a new item to the list
    public static final DeferredItem<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROCHE = ITEMS.register("roche",
            () -> new Item(new Item.Properties()));

    //This is the function that registers the list of items created earlier
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
