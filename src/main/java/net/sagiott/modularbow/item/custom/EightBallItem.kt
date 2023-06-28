package net.sagiott.modularbow.item.custom

import net.minecraft.ChatFormatting
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import net.minecraft.util.RandomSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class EightBallItem(properties: Properties) : Item(properties)
{
    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack>
    {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND)
        {
            outputRandomNumber(player)
            player.cooldowns.addCooldown(this, 20)
        }

        return super.use(level, player, hand)
    }

    override fun appendHoverText(stack: ItemStack, level: Level?, components: MutableList<Component>, flags: TooltipFlag)
    {
        if (Screen.hasShiftDown())
        {
            components.add(Component.literal("Right click to get a random number").withStyle(ChatFormatting.GOLD))
        }
        else
        {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.DARK_GRAY))
        }

        super.appendHoverText(stack, level, components, flags)
    }

    private fun outputRandomNumber(player: Player)
    {
        player.sendSystemMessage(Component.literal("Il numero è ${getRandomNumber()}"))
    }

    private fun getRandomNumber() : Int
    {
        return RandomSource.createNewThreadLocalInstance().nextInt(10)
    }
}