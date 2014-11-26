require 'rubygems'
require 'sinatra/base'
require "./users"
class MyApp < Sinatra::Base

	$user = Users.new()

	get '/' do
		"Hello World"
	end

	get '/user/:data' do
		temp = params[:data]
		usr = $user.validateUser(temp)
		usr
	end

end

