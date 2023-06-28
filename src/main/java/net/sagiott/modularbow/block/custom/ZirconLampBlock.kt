package net.sagiott.modularbow.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.phys.BlockHitResult

class ZirconLampBlock(properties: Properties) : Block(properties)
{
    companion object
    {
        val LIT: BooleanProperty = BooleanProperty.create("lit")
    }

    override fun use(state: BlockState, level: Level, pos: BlockPos, player: Player, hand: InteractionHand, result: BlockHitResult): InteractionResult
    {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND)
        {
            level.setBlock(pos, state.cycle(LIT), 3)
        }

        return super.use(state, level, pos, player, hand, result)
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>)
    {
        builder.add(LIT)
    }
}