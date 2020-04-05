#MongoCloud
MONGO_URI = 'mongodb+srv://conexionmongoCloud'

#MongoDb
#MONGO_HOST = 'MONGO_HOST'
#MONGO_PORT = MONGO_PORT
#MONGO_USERNAME = 'MONGO_USERNAME'
#MONGO_PASSWORD = MONGO_PASSWORD'
#MONGO_DBNAME = 'MONGO_DBNAME'

URL_PREFIX = 'api'
API_VERSION = 'v1'
RESOURCE_METHODS = ['GET']
X_DOMAINS = '*'
HATEOAS = False
DATE_FORMAT='%Y-%m-%dT%H:%M:%S%z'

cases_schema = {
    'item_title' : 'cases',
    'schema' : {
        'name': {'type':'string'},
        'totalCases': {'type':'integer'},
        'newCases': {'type':'string'},
        'totalDeaths': {'type':'integer'},
        'newDeaths': {'type':'string'},
        'totalRecovered': {'type':'integer'},
        'activeCases': {'type':'integer'},
        'seriousCritical': {'type':'integer'},
        'totCasesOneMperPop': {'type':'string'},
        'totDeathsOneMperPop': {'type':'string'},
        'date': {'type':'date'}
    }
}

DOMAIN = {'cases' : cases_schema}