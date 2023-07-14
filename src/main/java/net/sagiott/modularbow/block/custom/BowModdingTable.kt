package net.sagiott.modularbow.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class BowModdingTable(properties: Properties) : Block(properties)
{
    //table to modify the bow
    override fun use(state: BlockState, level: Level, pos: BlockPos, player: Player, hand: InteractionHand, result: BlockHitResult): InteractionResult
    {
        //open modifcation guy

        return super.use(state, level, pos, player, hand, result)
    }
}