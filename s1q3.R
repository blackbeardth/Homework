# S1 Q3

# install.packages('rattle.data')
install.packages("./data/rattle.data_1.0.2.tar.gz", repos = NULL, type = "source")


# defines a function standardize which takes one argument x
# this function calculates z score
standardize = function(x) {
  z <- (x - mean(x)) / sd(x)
  return( z)
}

# this function prints name, mean and std dev. of each attribute in the dataset
print_dataframe = function(df) {
  for (attr in colnames(df)) {
    cat("Attribute:", attr)
    cat("\n\tMean:", mean(df[, attr]))
    cat("\n\tStd. Dev.:", sd(df[, attr]))
    cat("\n\n")
  }
}

library(rattle.data)
#wine <- read.csv('./data/wine.csv') 
View(wine)

# removes the first column from dataframe
wine_data <- wine[-c(1, 1)]
wine_data

print_dataframe(wine_data)

# standardizes each coloumn of the dataframe using standardize function
wine_data <- apply(wine_data, 2, standardize)

print_dataframe(wine_data)

# On IRIS Dataset
library(datasets)
data(iris)

iris_data <- iris[-c(1, 5)]
iris_data

print_dataframe(iris_data)

iris_data <- apply(iris_data, 2, standardize)

print_dataframe(iris_data)

