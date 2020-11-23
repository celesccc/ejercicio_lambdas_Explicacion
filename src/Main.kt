fun main(args: Array<String>) {

    // Las lambdas son funciones sin nombre.
    { println("Esto es una lamba vacía. ") } // Nadie ejecuta esta lambda, por lo que que nuca se escribirá

    // Podemos asignar lambdas a funciones.
    val lambda = {
        println("Esto es una lamba en una variable.")
    }
    // Y las ejecutamos así.
    lambda()

    // Es posiblre definir parámetros para la lambda: nombre: Tipo ->
    val lambdaParametro = {
            num: Int -> println("He recibido $num como parametro.")
    }
    // Y las ejecutamos así.
    lambdaParametro(1)

    //////////
    val lambdaParametro2 = { num: Int ->
        repeat(num){
            println("He recibido $num como parametro.")
        }
    }
    lambdaParametro2(2)
    ////////////////


    // En este caso indicamos explicitamente que la lambda requiere de dos parametros Int y que devuelve un Int.
    // Atencion, devuelve la ultima linea de la lambda
    val hazSuma: (Int, Int) -> Int = { num1: Int, num2: Int ->
        if (true) {
            num1 + num2
        } else
            num1
    } //Esta lambda devuelve lo que hay en el if

    // listOf<Int>().forEach{contador : Int -> print(contador)} El forEach pide una lambda con un Entero
    //listOf<Int>().forEach{print(it)}
    val hazResta: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 - num2 }


    println("Sumo ${hazSuma(2,1)} como parametro.")
    println("Resto ${hazResta(2,1)} como parametro.")

    //Le podemos pasar una función como parámetro:
    println("Sumo ${example(hazSuma)} desde una lambda.")
    println("Resto ${example(hazResta)} desde una lambda.")

    listOf<Any>().filter({ elemento : Any -> elemento != null })
    // listOf<Any>().filter{ it != null }
}

fun example(functionAsParameter: (Int, Int) -> Int) : Int {
    return functionAsParameter(2,1)
}