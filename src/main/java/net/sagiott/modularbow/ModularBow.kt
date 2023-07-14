package net.sagiott.modularbow

import com.mojang.logging.LogUtils
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.sagiott.modularbow.block.ModBlocks
import net.sagiott.modularbow.item.ModItems
import net.sagiott.modularbow.util.ModItemProperties
import thedarkcolour.kotlinforforge.forge.MOD_CONTEXT

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModularBow.MOD_ID)
class ModularBow
{
    init
    {
        val modEventBus = MOD_CONTEXT.getKEventBus()
        //Add items to event bus
        ModItems.register(modEventBus)
        //Add blocks to event bus
        ModBlocks.register(modEventBus)

        modEventBus.addListener()
        {
            event: FMLCommonSetupEvent -> commonSetup(event)
        }
        MinecraftForge.EVENT_BUS.register(this)
    }

    private fun commonSetup(event: FMLCommonSetupEvent)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent?)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting")
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientModEvents
    {
        @SubscribeEvent
        fun onClientSetup(event: FMLClientSetupEvent?)
        {
            ModItemProperties.addCustomItemProperties()
        }
    }

    companion object
    {
        // Define mod id in a common place for everything to reference
        const val MOD_ID = "modularbow"
        private val LOGGER = LogUtils.getLogger()
    }
}
