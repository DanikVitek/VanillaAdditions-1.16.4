Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(4, 15, 6, 13, 19, 10),
Block.makeCuboidShape(4, 4, 6, 4, 15, 10),
Block.makeCuboidShape(0, 4, 6, 4, 19, 10),
Block.makeCuboidShape(10.5, 4, 7, 10.5, 15, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});