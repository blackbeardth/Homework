library(readxl) # for data manipulation
library(ggplot2) # for data visualization
library(dbscan) # for clustering
library(rpart) # for decision tree modeling
library(rpart.plot) # for data visualization
library(caret) # machine learning tools
library(e1071) # machine learning tools
library(class) # machine learning tools
library(fpc) # for clustering

perf <- read_excel("./data/perfume_data.xlsx", col_names = FALSE)
summary(perf)
perf_feat <- perf
perf_feat$...1 <- NULL

# using kmeans

kmeansModel <- kmeans(perf_feat, 3)
kmeansModel

perf_feat$cluster <- factor(kmeansModel$cluster)
perf_feat$cluster

plot(perf_feat[2:5],col=kmeansModel$cluster)

# using dbscan

perf_feat <- perf[-c(1,1)]
kNNdistplot(perf_feat, k=3)

dbscanModel <- dbscan(perf_feat, .5, 1)
dbscanModel

perf_feat$cluster <- factor(dbscanModel$cluster)
perf_feat$cluster

plot(perf_feat[2:5],col=kmeansModel$cluster)

# using hierarchical clustering

perf_feat <- perf[-c(1,1)]

hcModel <- hclust(dist(perf_feat), method="average") 

plot(hcModel, hang = -1, labels=perf$...1)

rect.hclust(hcModel, k=3)

perf_feat$cluster <- factor(cutree(hcModel, k=3))
perf_feat$cluster

plot(perf_feat[2:5],col=perf_feat$cluster)
