from flask import Flask, render_template, request
import pickle  # Dacă folosești un model încărcat dintr-un fișier

app = Flask(__name__)

# Încarcă modelul din fișier
model = pickle.load(open('model.pkl', 'rb'))

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Extragerea datelor din formular
        features = [float(x) for x in request.form.values()]
        # Predictia clusterului
        prediction = model.predict([features])[0]  # obține prima predicție

        # Descrierile pentru fiecare cluster
        descrieri_cluster = {
            0: " Semințe mari și uniforme: Ideale pentru practici agricole ce valorizează predictibilitatea.",
            1: " Semințe mici și variate: Pot proveni de la plante sălbatice sau necultivate, oferind o diversitate genetică mai mare.",
            2: " Semințe de dimensiuni moderate, simetrice: Preferate pentru calitățile lor estetice și simetrie."
        }

        # Afișarea descrierii pentru clusterul prezis
        descriere_cluster = descrieri_cluster.get(prediction, "Cluster necunoscut")

        return f"Cluster prezis: [{prediction}] - {descriere_cluster}"
    except Exception as e:
        return str(e)

if __name__ == '__main__':
    app.run(debug=True)