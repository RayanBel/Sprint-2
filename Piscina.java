class Piscina{ // Pool
    float largo; // length
    float ancho; // width
    float hondo; // depth 
    // Constructor: defines the values of the entity
    Piscina(float x, float y, float z){
        largo=x;
        ancho=y;
        hondo=z;
    }
    // Dimention: gives an array with the lenght, width and depth; in this order
    float[] dimension(){
        float[] dim={largo, ancho, hondo};
        return dim;
    }
    // Area=x*y
    float area(){
        return ancho*largo;
    }
    // Volume=x*y*z
    float volumen(){
        return area()*hondo;
    }
    // Show all the atributes of the entity
    void valores(){
        System.out.println("Largo: "+largo+" m\nAncho: "+ancho+" m\nProfundidad: "+hondo+" m.");
    }
    // Total Area= x1*y1 + x2*y2 + ... + xN*yN
    static float areaTotal(Piscina[] piscina){
        float area =0;
        for(int i=0;i<piscina.length;i++)
            area+=piscina[i].area();
        return area;
    }
    // Total Volume= x1*y1*z1 + x2*y2*z2 ... xn*yn*zn
    static float volumenTotal(Piscina[] piscina){
        float volumen=0;
        for(int i=0;i<piscina.length;i++)
            volumen+=piscina[i].volumen();
        return volumen;
    }
    // Total Width= width1+width2+ ... + widthN
    static float anchoTotal(Piscina[] piscina){
        float ancho=0;
        for(int i=0;i<piscina.length;i++)
            ancho+=piscina[i].ancho;
        return ancho;
    }
    // Exchanges values between two pools (con Referencias|with References)
    static void intercambiarHondo(Piscina uno, Piscina dos){
        float x=uno.hondo;
        uno.hondo=dos.hondo;
        dos.hondo=x;
    }
    public static void main(String[] args) {
        // Creates a pool array
        Piscina[] piscina = {new Piscina(300, 150, 20), new Piscina(300, 80, 35)};
        System.out.println("El área de la piscina 1 es de "+piscina[0].area()+" m² y el de la piscina 2 es de "+piscina[1].area()+" m².");
        System.out.println("El volumen de la piscina 1 es de "+piscina[0].volumen()+" m³ y el de la piscina 2 es de "+piscina[1].volumen()+" m³.");
        // Se presupone, por el enunciado, que el largo siempre será igual entre las piscinas.
        System.out.println("Si ponemos las piscinas pegadas tendrían un ancho de "+anchoTotal(piscina)+" m y un largo de "+piscina[0].dimension()[0]+" m.");
        System.out.println("El área conjunta de ambas piscinas es de "+areaTotal(piscina)+" m².");
        System.out.println("El volumen conjunto de ambas piscinas es de "+volumenTotal(piscina)+" m³.");
        intercambiarHondo(piscina[0], piscina[1]);
        System.out.println("Si intercambiamos la profundidad, los nuevos valores serán los siguientes ->");
        for(int i=0;i<piscina.length;i++){
            System.out.println("Piscina "+(i+1));
            piscina[i].valores();
            System.out.println("El nuevo volumen es de "+piscina[i].volumen()+" m³.\n");
        }
    }
}
// Ya sé, el programa es más complejo de lo que se pedía. Pero lo desarrolle para que fuera escalable.
// Si tuviera que calcular 100 piscinas, este mismo programa serviría con cambios mínimos.