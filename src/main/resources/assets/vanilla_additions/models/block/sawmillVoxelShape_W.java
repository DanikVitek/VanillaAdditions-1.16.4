Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(3, 15, 6, 12, 19, 10),
Block.makeCuboidShape(12, 4, 6, 12, 15, 10),
Block.makeCuboidShape(12, 4, 6, 16, 19, 10),
Block.makeCuboidShape(5.5, 4, 7, 5.5, 15, 9)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});