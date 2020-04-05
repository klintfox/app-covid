from eve import Eve

app = Eve()

if __name__ == '__main__':
    #app.run()
    app.run(host='localhost', port=5000, debug=False)
