# S1 Q2

# fileurl <- 'http://raw.github.com/edwindj/datacleaning/master/data/dirty_iris.csv'
# download.file(fileurl, destfile = './data/dirty_iris.csv')

dirty_iris <- read.csv('./data/dirty_iris.csv')
View(dirty_iris)

# Q2 i
# cat() is used to print concatenated objects to console
cat(
  'No. of Observations: ',
  sum(complete.cases(dirty_iris)), "\n"
)

c <- sum(complete.cases(dirty_iris))

cat(
  'Pc. of Observations: ', 
  c / (dim(dirty_iris)[1]) * 100, "\n\n"
)

# Q2 ii
# This step aims to convert potentially string-formatted numeric data into actual numeric data
dirty_iris[, -5] = lapply(
  dirty_iris[, -5], 
  function(y) as.numeric(as.character(y))
)

# Q2 iii
library(editrules)

# we read the edit rules from a file
E <- editfile('./data/s1q2-rules.txt')
E

# Q2 iv

# we apply those rules to our dataset and check for any voilations
violations <- violatedEdits(E, dirty_iris)
violations
summary(violations)
plot(violations)

# Q2 v
boxplot(dirty_iris$Sepal.Length)
boxplot.stats(dirty_iris$Sepal.Length)$out
