package net.sagiott.modularbow.item

import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.sagiott.modularbow.ModularBow
import net.sagiott.modularbow.item.custom.EightBallItem

class ModItems
{
    companion object
    {
        //List of every object for the mod
        val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ModularBow.MOD_ID)
        /*
        To add a new object just create a val OBJECT_NAME: RegistryObject<Item> = ITEMS.register("object_name") { Item(Item.Properties().tab(creative_tab)) },
        then add the item_name.png or whatever in the resources/assets/modularbow/textures/item,
        add the item_name.json in resources/assets/modularbow/models/item with this layout
        {
            "parent" : "item/generated",
            "textures" :
            {
                "layer0" : "modularbow:item/item_name"
            }
        }
        add the localization in the resources/assets/modularbow/lang for every localization.json file.
        */
        //Commento random
        val ZIRCON: RegistryObject<Item> = ITEMS.register("zircon") { Item(Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)) }

        val RAW_ZIRCON: RegistryObject<Item> = ITEMS.register("raw_zircon") { Item(Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)) }

        val EIGHT_BALL: RegistryObject<Item> = ITEMS.register("eight_ball") { EightBallItem(Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).stacksTo(1)) }

        fun register(eventBus: IEventBus)
        {
            ITEMS.register(eventBus)
        }
    }
}