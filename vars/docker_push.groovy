def call(String credId, String imageName){
   withCredentials([
            usernamePassword(
                credentialsId: "dockerHubCreds",
                passwordVariable: "dockerHubPass",
                usernameVariable: "dockerHubUser"
            )
        ]) {

            sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
            sh "docker image tag $imageName} ${dockerHubUser}/${imageName}"
            sh "docker push ${dockerHubUser}/${imageName}"
            echo "Uploaded to Docker Hub"

        }  
}
