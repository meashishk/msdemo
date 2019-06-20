Simple deployment manifest.

---
 apiVersion: extensions/v1beta1
 kind: Deployment
 metadata:
   name: message-service
 spec:
   selector:
     matchLabels:
       app: message-service
   strategy:
     type: RollingUpdate
     rollingUpdate:
       maxUnavailable: 1
       maxSurge: 1
     replicas: 2
     template:
       metadata:
         labels:
           app: message-service
       spec:
         containers:
           - image: gcr.io/ms-samples/message-service:2.0
             imagePullPolicy: Always
             name: message-service 
             ports:
             - containerPort: 8000
             readinessProbe:
               httpGet:
                 path: /
                 port: 8000
                 initialDelaySeconds: 5
                 periodSeconds: 5
                 successThreshold: 1


replicas – Tells Kubernetes how many pods to create during a deployment.

spec.strategy.type – the strategy used to replace old Pods by new ones. The type can be “Recreate” or “RollingUpdate”. 

spec.strategy.rollingUpdate.maxUnavailable - This is an optional field that specifies the maximum number of Pods that can be unavailable during	the update process. The value can be an absolute number or a percentage of desired Pods.

spec.strategy.rollingUpdate.maxSurge - This is an optional field that specifies the maximum number of Pods that can be created over the desired number of Pods.

spec.template.metadata.labels – Adds labels to a deployment specification.

spec.selector – An optional object that tells the Kubernetes deployment controller to only target pods that match the specified labels.

Readiness Probe. Readiness Probe makes sure that the new pods created are ready to take on requests before terminating the old pods.

initialDelaySeconds: Number of seconds after the container has started before readiness probes are initiated.

periodSeconds: How often to perform the probe. Default to 10 seconds.

successThreshold: Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1. Must be 1 for 		liveness. 
