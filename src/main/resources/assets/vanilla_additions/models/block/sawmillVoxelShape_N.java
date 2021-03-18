Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(6, 15, 3, 10, 19, 12),
Block.makeCuboidShape(6, 4, 12, 10, 15, 12),
Block.makeCuboidShape(6, 4, 12, 10, 19, 16),
Block.makeCuboidShape(7, 4, 5.5, 9, 15, 5.5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});