public class Metal extends Material {
  private Vector albedo; 

  Metal(Vector a) {
    albedo = a; 
  }
  public boolean scatter(Ray rayIn, FormHit hit, Vector attenuation, Ray scattered) {
    Vector reflected = reflect(rayIn.direction().unitVector(), hit.normal); 
    scattered.set(new Ray(hit.p, reflected));
    attenuation.set(albedo);
    return scattered.direction().dot(hit.normal) > 0;
  }

  private Vector reflect(Vector v, Vector n) {
    return v.subtract(n.multiply(2 * v.dot(n)));
  }
}