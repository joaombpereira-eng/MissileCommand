import pt.isel.canvas.*

fun main() {

    onStart {
        val canvas = Canvas(800,600, BLACK)
        var explosionView: ExplosionView = ExplosionView(
            Explosion(Location(0.0,0.0),0.0,0.0),
            RED
        )

        canvas.onMouseDown {
            explosionView = ExplosionView(
                Explosion(Location(it.x.toDouble(), it.y.toDouble()),5.0,1.06),
                RED
            )
        }

        val missile = Missile(
            Location(100.0, 0.0),
            Location(canvas.width / 2.0, canvas.height / 2.0),
            Velocity(0.0, 0.0)
        )

        canvas.onTimeProgress(25) {
            val maybeNewExplosion: Explosion =
                if (explosionView.data.rate > 1.0)
                    expandUntil(explosionView.data,50.0)
                else
                    contractUntilZero(explosionView.data)

            val newExplosion =
                if (maybeNewExplosion == explosionView.data)
                    Explosion(maybeNewExplosion.center, maybeNewExplosion.radius,0.94)
                else
                    maybeNewExplosion

            explosionView = ExplosionView(newExplosion, explosionView.color)

            canvas.erase()
            drawExplosion(canvas, explosionView)
            drawMissile(canvas, missile, 0xFF0000)
        }
    }

    onFinish {
        println("Bye bye!")
    }
}