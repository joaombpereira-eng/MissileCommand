import pt.isel.canvas.*

const val MARGIN = 50

fun main() {

    onStart {
        val canvas = Canvas(WORLD_WIDTH, WORLD_HEIGHT, BLACK)

        val entry = Location((MARGIN..WORLD_WIDTH - MARGIN).random().toDouble(),0.0)
        val target = Location((MARGIN..WORLD_WIDTH - MARGIN).random().toDouble(), WORLD_HEIGHT.toDouble())

        var world = World(Missile(entry, entry, computeVelocity(entry, target)))

        canvas.onMouseDown {
            world = World(
                    world.missile,
                    Explosion(
                            Location(it.x.toDouble(), it.y.toDouble()))
            )
        }

        canvas.onTimeProgress(25) {
            world = doStep(world)
            drawWorld(canvas, world)
        }
    }

    onFinish {
        println("Bye bye!")
    }
}