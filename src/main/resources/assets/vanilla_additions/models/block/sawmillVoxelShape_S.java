Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(6, 15, 4, 10, 19, 13),
Block.makeCuboidShape(6, 4, 4, 10, 15, 4),
Block.makeCuboidShape(6, 4, 0, 10, 19, 4),
Block.makeCuboidShape(7, 4, 10.5, 9, 15, 10.5)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});