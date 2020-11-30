import pt.isel.canvas.*

const val MARGIN = 50

fun main() {

    onStart {
        val canvas = Canvas(WORLD_WIDTH, WORLD_HEIGHT, BLACK)
        val missiles: List<Missile> = listOf(
                createMissile(WORLD_WIDTH, WORLD_HEIGHT, MARGIN),
                createMissile(WORLD_WIDTH, WORLD_HEIGHT, MARGIN),
                createMissile(WORLD_WIDTH, WORLD_HEIGHT, MARGIN)
        )
        var world = World(missiles)

        canvas.onMouseDown {
            world = addExplosionToWorld(world, Location(it.x.toDouble(), it.y.toDouble()))
        }

        canvas.onTimeProgress(period = 25) {
            // Apply time passing to the world
            world = computeNextWorld(world)
            drawWorld(canvas, world)
        }
    }

    onFinish {
        println("Bye bye!")
    }
}