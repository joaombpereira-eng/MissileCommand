import pt.isel.canvas.*

fun main() {

    onStart {
        var world = initializedWorld()
        val canvas = Canvas(world.width, world.height, BLACK)

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