//Programa para probar compilador C
//	Autores:
// 		Jhony Caro  20191020055
//		Bryan Muñoz 20162020408

#include <SFML/Graphics.hpp>

int main() {
    // Creamos una ventana de tamaño 800x600 píxeles
    sf::RenderWindow window(sf::VideoMode(800, 600), "Ejemplo SFML");

    // Creamos un objeto de círculo con radio 100 píxeles
    sf::CircleShape circle(100.f);

    // Establecemos el color del círculo a azul
    circle.setFillColor(sf::Color::Blue);

    // Bucle principal
    while (window.isOpen()) {
        // Manejamos eventos
        sf::Event event;
        while (window.pollEvent(event)) {
            if (event.type == sf::Event::Closed) {
                window.close();
            }
        }

        // Limpiamos la ventana (la llenamos de negro)
        window.clear(sf::Color::Black);

        // Dibujamos el círculo en la ventana
        window.draw(circle);

        // Mostramos la ventana
        window.display();
    }

    return 0;
}

