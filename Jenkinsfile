node{
  stage('SCM Checkout'){
    git 'https://github.com/AmigoManuel/poiExample'
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
}
