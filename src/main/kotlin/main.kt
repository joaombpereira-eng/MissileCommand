import pt.isel.canvas.*

fun main() {

    onStart {
        val canvas = Canvas(800,600, BLACK)

        var world = World(
                Missile(
                        Location(100.0, 0.0),
                        Location(200.0, 200.0),
                        Velocity(0.0,0.0),
                        RED),
                Explosion(
                        Location(150.0, 150.0),
                        5.0,
                        1.03,
                        RED)
        )

        canvas.onMouseDown {
            // Always the mouse is pressed
            world = TODO()
        }

        canvas.onTimeProgress(25) {
            // Apply time passing to the world
            world = doStep(world)
            drawWorld(canvas, world)
        }
    }

    onFinish {
        println("Bye bye!")
    }
}