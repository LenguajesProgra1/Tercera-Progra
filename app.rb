require 'rubygems'
require 'sinatra/base'

$user=Users.new()

class MyApp < Sinatra::Base
	get '/' do
		"Hello World"
	end

	get '/user/:data' do
		temp = params[:data]
		usr = user.validateUser(temp)
		usr
	end

end

