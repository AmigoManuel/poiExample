pipeline {

    agent any
    
    parameters{
        choice(name: 'door_choice',
            choices: 'one\ntwo\nthree\nfour',
            description: 'What door do you choose')
        booleanParam(name: 'CAN_DANCE',
            defaultValue: true,
            description: 'Checkbox parameter')
        string(name: 'sTranGepaRaM',
            defaultValue: 'Dance!',
            description: 'Do the funky chicken!')
        password(name: 'PASSWORD',
            defaultValue: 'SECRET',
            description: 'A secret password')
        text(name: 'BIOGRAPHY', 
            defaultValue: 'Insert a story', 
            description: 'Enter some information about the person')
        }
        
        stages{
        
    	stage('Example one'){
        	steps{     	    
        		echo "param1: ${door_choice}"
        		echo "param2: ${CAN_DANCE}"
        		echo "param3: ${sTranGepaRaM}"
        		echo "param4: ${PASSWORD}"
        		echo "param5: ${BIOGRAPHY}"
        	}
        }
    }
}
