# jas-demo

## JFrog CLI config
```dtd
jf mvnc
Configuration file already exists at /Users/wangq/Documents/code/app-boot/.jfrog/projects/maven.yaml. Override it? (y/n) [n]? y
Resolve dependencies from Artifactory? (y/n) [y]? y
Set Artifactory server ID [soleng]: 
Set resolution repository for release dependencies (press Tab for options): alex-maven-virtual
Set resolution repository for snapshot dependencies (press Tab for options): alex-maven-virtual
Deploy project artifacts to Artifactory? (y/n) [y]? y
Set Artifactory server ID [soleng]: soleng
Set repository for release artifacts deployment (press Tab for options): alex-maven-virtual
Set repository for snapshot artifacts deployment (press Tab for options): alex-maven-virtual
Would you like to filter out some of the deployed artifacts? (y/n) [n]? n
15:30:56 [🔵Info] maven build config successfully created.

```

## Index build by API
```dtd
 curl -u alexwang:${token} -X POST "https://${artifactory}/xray/api/v1/binMgr/builds" \
        -H "Content-Type: application/json" \
        -d '{
        "names": ["jas-demo"]
        }'

```

## Maven build and publish build info to Artifactory
Build the project, while deploying artifacts to Artifactory
```dtd
jf mvn package
jf mvn deploy --build-name jas-demo --build-number 1
jf rt bag
jf rt bce jas-demo  1
jf rt bp  jas-demo  1
```

##  Docker build and scan
```
docker login acme.jfrog.io
docker build -t jas-demo .
docker tag jas-demo acme.jfrog.io/alexwang-docker/jas-demo:v1
docker push acme.jfrog.io/alexwang-docker/jas-demo:v1
jf docker push acme.jfrog.io/docker-local/docker-app --build-name=docker-app --build-number=1
jf rt bp docker-app 1
```