package net.sagiott.modularbow.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class JumpyBlock(properties: Properties) : Block(properties)
{
    override fun use(state: BlockState, level: Level, pos: BlockPos, player: Player, hand: InteractionHand, result: BlockHitResult): InteractionResult
    {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND)
        {
            player.sendSystemMessage(Component.literal("Ha attivato il blocco"))
        }

        return super.use(state, level, pos, player, hand, result)
    }

    override fun stepOn(level: Level, pos: BlockPos, state: BlockState, entity: Entity)
    {
        if(entity is LivingEntity)
        {
            entity.addEffect(MobEffectInstance(MobEffects.JUMP, 200))
        }

        super.stepOn(level, pos, state, entity)
    }
}