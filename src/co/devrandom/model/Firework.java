package co.devrandom.model;

import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.BodyType;

import co.devrandom.main.GameState;
import co.devrandom.util.Vector;
import co.devrandom.vc.TextureAttributes;
import co.devrandom.vc.TextureList;

public class Firework extends PhysicsObject {
	private static final float DENSITY = 0.1f;
	private static final float FRICTION = 1f;
	private static final float RESTITUTION = 0.0001f;
	private static final float GRAVITY = 1f;
	private static final Shape SHAPE = PhysicsObject.makeBoxShape(0.1f, 1f);
	private static final TextureAttributes TEX_ATTRIBUTES = new TextureAttributes(
			TextureList.DOT);
	
	public Firework(Model model, Vector position) {
		super(model, position, BodyType.DYNAMIC,
				SHAPE, DENSITY, FRICTION, RESTITUTION, GRAVITY, TEX_ATTRIBUTES);
	}
	
	public void launch() {
		this.getBody().applyForceToCenter(new Vec2(0f, -100f));
	}
	
	public void explode() {
		GameState.PING.playAsSoundEffect(1.0f, 1.0f, false);
		Vec2 pos = this.getBody().getPosition();
		
		for (int i = 0; i < 50; i++) {
			Vector rand = new Vector((float) Math.random() - 0.5f, (float) Math.random() - 0.5f).scale(20.0f);
			Particle part = new Particle(this.getModel(), new Vector(pos.x, pos.y).plus(rand));
			
			part.getBody().applyForceToCenter(rand.toVec2());
			
			this.getModel().addPhysicsObject(part);
		}
		
		this.getModel().getWorld().destroyBody(this.getBody());
		this.getModel().removePhysicsObject(this);
	}
}
