def shortlink(request):
    if request['method'] is not 'POST':
        return Response(501)  # HTTP 501 NOT IMPLEMENTED

    destination = request['data']['destination']
    if 'slug' in request['data']:
        # If they included a slug, use that
        slug = request['data']['slug']
    else:
        # Else, make them one
        slug = generate_random_slug()

    DB.insert({'slug': slug, 'destination': destination})

    response_body = { 'slug': slug }
    return Response(200, json.dumps(response_body))  # HTTP 200 OK

def redirect(request):
    destination = DB.get({'slug': request['path']})['destination']
    return Response(302, destination)

def generate_random_slug():
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    num_chars = 7
    return ''.join([random.choice(alphabet) for _ in xrange(num_chars)])