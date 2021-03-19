pipeline {

    agent any
    
        parameters{
            choice(
                name: 'choice_field',
                choices: 'first\nsecond\nthird\nfourth',
                description: 'Place of the competitor'
            )
            booleanParam(
                name: 'checkbox_field',
                defaultValue: true,
                description: 'Have reached the goal?'
            )
            string(
                name: 'string_field',
                defaultValue: 'Sedan',
                description: 'Car model'
            )
            text(
                name: 'text_area', 
                defaultValue: 'Insert a story', 
                description: 'Enter some information about the person'
            )
        }
        
        stages{
        
    	stage('Example one'){
        	steps{
                echo "param1: ${choice_field}"
                echo "param2: ${checkbox_field}"
                echo "param3: ${string_field}"
                echo "param4: ${text_area}"
                echo "Hello World ${choice_field}"
                echo "php -version"
        	}
        }
    }
}
